package example

import shapeless.ops.hlist
import hlist.Intersection
import hlist.Align

object ShapelessOps {

  import shapeless._

  implicit class AlignerOps[ARepr <: HList](a: ARepr) {
    def as[B](implicit aligner: Aligner[ARepr, B]): B = aligner.apply(a)
  }

  trait Aligner[A, B] {
    def apply(a: A): B
  }

  implicit def genericAligner[ARepr <: HList, Unaligned <: HList, B, BRepr <: HList](
    implicit
    bGen    : LabelledGeneric.Aux[B, BRepr],
    inter   : Intersection.Aux[ARepr, BRepr, Unaligned],
    align   : Align[Unaligned, BRepr],
  ): Aligner[ARepr, B] = new Aligner[ARepr, B] {
    def apply(a: ARepr): B = bGen.from(align(inter(a)))
  }

  implicit class GenericOps[A, ARepr <: HList](val a: A)(implicit gen: LabelledGeneric.Aux[A, ARepr]) {
    def repr: ARepr = LabelledGeneric[A].to(a)
  }

}
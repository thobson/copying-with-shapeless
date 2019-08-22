package example

object ShapelessOps {

  import shapeless._
  import shapeless.ops.hlist

  // 1
  implicit class AlignerOps[ARepr <: HList](a: ARepr) {
    def as[B](implicit aligner: Aligner[ARepr, B]): B = aligner.apply(a)
  }

  // 2
  trait Aligner[A, B] {
    def apply(a: A): B
  }

  // 3
  implicit def genericAligner[ARepr <: HList, B, BRepr <: HList](
    implicit
    bGen    : LabelledGeneric.Aux[B, BRepr],
    align   : hlist.Align[ARepr, BRepr]
  ): Aligner[ARepr, B] = new Aligner[ARepr, B] {
    def apply(a: ARepr): B = bGen.from(align.apply(a))
  }

}
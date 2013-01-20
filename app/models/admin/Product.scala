package models.admin

import play.api.libs.json.{JsNumber, Json, Writes}

case class Product(
  ean: Long,
  name: String,
  description: String,
  price: BigDecimal
)

import Json._

object AdminProductWrites extends Writes[Product] {
  def writes(p: Product) = toJson(
    Map(
      "ean" -> toJson(p.ean),
      "name" -> toJson(p.name),
      "description" -> toJson(p.description),
      "price" -> JsNumber(p.price)
    )
  )
}


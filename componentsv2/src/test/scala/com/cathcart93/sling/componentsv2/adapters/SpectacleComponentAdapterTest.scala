package com.cathcart93.sling.componentsv2.adapters

import org.scalatest.mockito.MockitoSugar
import org.scalatest.{FlatSpec, Matchers}
import com.cathcart93.sling.componentsv2.models.{BlockQuote, HeadingModel, SlideModel, Component => ComponentModel}
import org.apache.sling.testing.mock.sling.builder.ContentBuilder
import org.apache.sling.testing.mock.sling.MockSling

import scala.collection.JavaConverters._

class SpectacleComponentAdapterTest extends FlatSpec with Matchers with MockitoSugar with SpectacleAdapters {

  val headingComponentProps: Map[String, AnyRef] = Map(
    "component" -> "Heading",
    "text" -> "Text",
    "size" -> 3.asInstanceOf[Integer],
    "fit" -> false.asInstanceOf[java.lang.Boolean],
    "lineHeight" -> 2.asInstanceOf[Integer]
  )
  val headingComponent = HeadingModel(text = "Text", size = 3, fit = false, lineHeight = 2)

  "Resource" should "be adaptable to component" in {
    val resolver = MockSling.newResourceResolver
    val contentBuilder = new ContentBuilder(resolver)
    val resourceMock = contentBuilder
      .resource("/text", headingComponentProps.asJava)

    val adaptationResult = resourceMock.adapt[ComponentModel]
    adaptationResult should be(headingComponent)
  }

  it should "be adaptable to Slide" in {
    val selfProps: Map[String, AnyRef] = Map(
      "bgColor" -> "green",
      "textColor" -> "black"
    )
    val resolver = MockSling.newResourceResolver
    val contentBuilder = new ContentBuilder(resolver)
    val slideResourceMock = contentBuilder
      .resource("/slide", selfProps.asJava)
    contentBuilder
      .resource("/slide/comp1", headingComponentProps.asJava)
    val adaptationResult = slideResourceMock.adapt[SlideModel]
    adaptationResult should be(SlideModel(bgColor = "green", textColor = "black", components = Seq(headingComponent)))
  }

  it should "be adaptable to BlockQuote" in {
    val selfProps: Map[String, AnyRef] = Map(
      "cite" -> "Author",
      "quote" -> "Quote"
    )
    val resolver = MockSling.newResourceResolver
    val contentBuilder = new ContentBuilder(resolver)
    val slideResourceMock = contentBuilder
      .resource("/quote", selfProps.asJava)
    val adaptationResult = slideResourceMock.adapt[BlockQuote]
    adaptationResult should be(BlockQuote(quote = "Quote", cite = "Author"))
  }
}

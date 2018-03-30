package com.cathcart93.sling.componentsv2.adapters

import com.cathcart93.sling.componentsv2.ResourceAdapter
import com.cathcart93.sling.componentsv2.models.{Component, HeadingModel}
import org.apache.sling.api.resource.Resource

object SpectacleComponentAdapter extends ResourceAdapter[Component] with ResourceAdaptableImplicit {
  implicit val headingAdapter: ResourceAdapter[HeadingModel] = HeadingAdapter

  override def adapt: Resource => Component = (resource: Resource) => {
    val valueMap = resource.getValueMap
    val componentName = valueMap.get("component", classOf[String])
    componentName match {
      case "Heading" => resource.adapt[HeadingModel]
      case _ => null
    }
  }
}

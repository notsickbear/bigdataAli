package com.api

import com.unit.sparkUnit
import com.unit.sparkUnit.findSaltedType
import org.springframework.web.bind.annotation.{GetMapping, PathVariable, RequestMapping, RestController}

@RequestMapping(Array("api/proType"))
@RestController
class ProTypeApi {
  @GetMapping(Array("{num}"))
  def getSaltedType(@PathVariable("num") num: Int):String ={
    findSaltedType(num=num)
  }
}

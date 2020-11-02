package com.api

import com.unit.sparkUnit.findSaltedPro
import org.springframework.web.bind.annotation.{GetMapping, PathVariable, RequestMapping, RestController}

import scala.util.parsing.json.JSONObject

@RequestMapping(Array("api/pro"))
@RestController
class ProApi {
  @GetMapping(Array("{num}"))
  def getSaltedPro(@PathVariable("num") num: Int):String ={
    findSaltedPro(num=num)
  }
}

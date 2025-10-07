package com.hotelbooking.controller;

import com.hotelbooking.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/search")
public class SearchController {

  @Autowired private SearchService searchService;

  // /api/search/hotels?city=Chennai&start=2025-09-01&end=2025-09-05
  @GetMapping("/hotels")
  public List<Map<String,Object>> search(
      @RequestParam String city,
      @RequestParam String start,
      @RequestParam String end) {
    return searchService.search(city, start, end);
  }
}

package com.crystalstudio.handymap;

import java.util.List;

public class SearchApiResponse {
    PlaceMeta meta;
    List<Place> documents;
}

class PlaceMeta{
    int total_count;
    int pageable_count;
    boolean is_end;
}

class Place{
    String place_name;
    String phone;
    String address_name, road_address_name;
    String x;
    String y;
    String distance;
    String place_url;
}
package com.example.torreapp.model

import com.example.torreapp.model.Link
import com.example.torreapp.model.Location

class Person (
    val name: String,
    val picture: String,
    val pictureThumbnail: String,
    val professionalHeadline: String,
    val location: Location,
    val summaryOfBio: String,
    val publicId: String,
    val links: List<Link>,
) {

}
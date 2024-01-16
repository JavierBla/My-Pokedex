package com.example.mypokedex.domain.pokemon

data class Other(
    val dream_world: DreamWorld = DreamWorld(),
    val home: Home = Home(),
    val official_artwork: OfficialArtwork = OfficialArtwork(),
)
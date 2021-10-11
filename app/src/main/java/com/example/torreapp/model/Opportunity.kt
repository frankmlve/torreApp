package com.example.torreapp.model

class Opportunity(
    val objective: String,
    val tagLinee: String,
    val type: String,
    val organizations: List<Organization>,
    val locations: List<String>,
    val remote: Boolean,
    val compensation: Compensation,
    val skills: List<Skill>,
    val members: List<Member>
) {

}
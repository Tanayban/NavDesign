package com.codingjuction.navigationpra.model

class CategoryModel {
    var name : String? = null
    var image : String? = null

    constructor():this("","") {}

    constructor(name: String, image: String) {
        this.name = name
        this.image = image
    }
}
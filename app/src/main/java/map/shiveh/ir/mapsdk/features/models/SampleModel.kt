package map.shiveh.ir.mapsdk.features.models

import map.shiveh.ir.mapsdk.app.base.Entity

class SampleModel: Entity {

    lateinit var message: String

    constructor() {

    }

    constructor(message: String) {
        this.message = message
    }
}

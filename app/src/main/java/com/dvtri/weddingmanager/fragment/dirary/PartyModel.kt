package com.dvtri.weddingmanager.fragment.dirary

data class PartyModel(
    var idUser: String,
    var partyName: String,
    var partyStatus: String,
    var partyDate: String,
    var partyOwner: String,
    var partyCost: Long,
    var partyType: String,
    var partyDetail: String,
    var partyImage: Int
) {
    var User: String? = null
    var Name: String? = null
    var Status: String? = null
    var Date: String? = null
    var Owner: String? = null
    var Cost: Long? = null
    var Type: String? = null
    var Detail: String? = null
    var Image: Int? = null

    init {
        this.User = idUser
        this.Name = partyName
        this.Status = partyStatus
        this.Date = partyDate
        this.Owner = partyOwner
        this.Cost = partyCost
        this.Type = partyType
        this.Detail = partyDetail
        this.Image = partyImage
    }

}
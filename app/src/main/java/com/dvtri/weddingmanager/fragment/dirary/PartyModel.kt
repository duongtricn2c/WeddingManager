package com.dvtri.weddingmanager.fragment.dirary

data class PartyModel(var partyName:String,
                      var partyStatus:String,
                      var partyDate:String,
                      var partyOwner:String,
                      var partyCost: Long,
                      var partyType:String,
                      var partyDetail:String,
                      var partyImage:Int) {
}
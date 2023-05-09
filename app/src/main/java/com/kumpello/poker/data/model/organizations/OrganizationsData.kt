package com.kumpello.poker.data.model.organizations

import com.kumpello.poker.data.model.ID
import java.sql.Timestamp

data class OrganizationsData (val organizations: List<OrganizationData>) : OrganizationsResponse{
}
package au.com.shiftyjelly.pocketcasts.models.type

import au.com.shiftyjelly.pocketcasts.payment.SubscriptionTier
import com.squareup.moshi.JsonClass
import java.time.Instant

@JsonClass(generateAdapter = true)
data class Membership(
    val subscription: Subscription?,
    val createdAt: Instant?,
    val features: List<MembershipFeature>,
) {
    fun hasFeature(feature: MembershipFeature): Boolean = true

    companion object {
        val Empty = Membership(
            subscription = null,
            createdAt = null,
            features = emptyList(),
        )
    }
}

@JsonClass(generateAdapter = false)
enum class MembershipFeature {
    NoBannerAds,
    NoDiscoverAds,
}
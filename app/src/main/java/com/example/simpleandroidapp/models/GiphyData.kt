package com.example.simpleandroidapp.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import androidx.annotation.Keep

@Keep
@JsonClass(generateAdapter = true)
data class GiphyData(
    @Json(name = "data")
    val `data`: List<Data?>?,
    @Json(name = "pagination")
    val pagination: Pagination?,
    @Json(name = "meta")
    val meta: Meta?
) {
    @Keep
    @JsonClass(generateAdapter = true)
    data class Data(
        @Json(name = "type")
        val type: String?,
        @Json(name = "id")
        val id: String?,
        @Json(name = "url")
        val url: String?,
        @Json(name = "slug")
        val slug: String?,
        @Json(name = "bitly_gif_url")
        val bitlyGifUrl: String?,
        @Json(name = "bitly_url")
        val bitlyUrl: String?,
        @Json(name = "embed_url")
        val embedUrl: String?,
        @Json(name = "username")
        val username: String?,
        @Json(name = "source")
        val source: String?,
        @Json(name = "title")
        val title: String?,
        @Json(name = "rating")
        val rating: String?,
        @Json(name = "content_url")
        val contentUrl: String?,
        @Json(name = "source_tld")
        val sourceTld: String?,
        @Json(name = "source_post_url")
        val sourcePostUrl: String?,
        @Json(name = "is_sticker")
        val isSticker: Int?,
        @Json(name = "import_datetime")
        val importDatetime: String?,
        @Json(name = "trending_datetime")
        val trendingDatetime: String?,
        @Json(name = "images")
        val images: Images?,
        @Json(name = "user")
        val user: User?,
        @Json(name = "analytics_response_payload")
        val analyticsResponsePayload: String?,
        @Json(name = "analytics")
        val analytics: Analytics?
    ) {
        @Keep
        @JsonClass(generateAdapter = true)
        data class Images(
            @Json(name = "original")
            val original: Original?,
            @Json(name = "downsized")
            val downsized: Downsized?,
            @Json(name = "downsized_large")
            val downsizedLarge: DownsizedLarge?,
            @Json(name = "downsized_medium")
            val downsizedMedium: DownsizedMedium?,
            @Json(name = "downsized_small")
            val downsizedSmall: DownsizedSmall?,
            @Json(name = "downsized_still")
            val downsizedStill: DownsizedStill?,
            @Json(name = "fixed_height")
            val fixedHeight: FixedHeight?,
            @Json(name = "fixed_height_downsampled")
            val fixedHeightDownsampled: FixedHeightDownsampled?,
            @Json(name = "fixed_height_small")
            val fixedHeightSmall: FixedHeightSmall?,
            @Json(name = "fixed_height_small_still")
            val fixedHeightSmallStill: FixedHeightSmallStill?,
            @Json(name = "fixed_height_still")
            val fixedHeightStill: FixedHeightStill?,
            @Json(name = "fixed_width")
            val fixedWidth: FixedWidth?,
            @Json(name = "fixed_width_downsampled")
            val fixedWidthDownsampled: FixedWidthDownsampled?,
            @Json(name = "fixed_width_small")
            val fixedWidthSmall: FixedWidthSmall?,
            @Json(name = "fixed_width_small_still")
            val fixedWidthSmallStill: FixedWidthSmallStill?,
            @Json(name = "fixed_width_still")
            val fixedWidthStill: FixedWidthStill?,
            @Json(name = "looping")
            val looping: Looping?,
            @Json(name = "original_still")
            val originalStill: OriginalStill?,
            @Json(name = "original_mp4")
            val originalMp4: OriginalMp4?,
            @Json(name = "preview")
            val preview: Preview?,
            @Json(name = "preview_gif")
            val previewGif: PreviewGif?,
            @Json(name = "preview_webp")
            val previewWebp: PreviewWebp?,
            @Json(name = "hd")
            val hd: Hd?,
            @Json(name = "480w_still")
            val wStill: WStill?
        ) {
            @Keep
            @JsonClass(generateAdapter = true)
            data class Original(
                @Json(name = "height")
                val height: String?,
                @Json(name = "width")
                val width: String?,
                @Json(name = "size")
                val size: String?,
                @Json(name = "url")
                val url: String?,
                @Json(name = "mp4_size")
                val mp4Size: String?,
                @Json(name = "mp4")
                val mp4: String?,
                @Json(name = "webp_size")
                val webpSize: String?,
                @Json(name = "webp")
                val webp: String?,
                @Json(name = "frames")
                val frames: String?,
                @Json(name = "hash")
                val hash: String?
            )

            @Keep
            @JsonClass(generateAdapter = true)
            data class Downsized(
                @Json(name = "height")
                val height: String?,
                @Json(name = "width")
                val width: String?,
                @Json(name = "size")
                val size: String?,
                @Json(name = "url")
                val url: String?
            )

            @Keep
            @JsonClass(generateAdapter = true)
            data class DownsizedLarge(
                @Json(name = "height")
                val height: String?,
                @Json(name = "width")
                val width: String?,
                @Json(name = "size")
                val size: String?,
                @Json(name = "url")
                val url: String?
            )

            @Keep
            @JsonClass(generateAdapter = true)
            data class DownsizedMedium(
                @Json(name = "height")
                val height: String?,
                @Json(name = "width")
                val width: String?,
                @Json(name = "size")
                val size: String?,
                @Json(name = "url")
                val url: String?
            )

            @Keep
            @JsonClass(generateAdapter = true)
            data class DownsizedSmall(
                @Json(name = "height")
                val height: String?,
                @Json(name = "width")
                val width: String?,
                @Json(name = "mp4_size")
                val mp4Size: String?,
                @Json(name = "mp4")
                val mp4: String?
            )

            @Keep
            @JsonClass(generateAdapter = true)
            data class DownsizedStill(
                @Json(name = "height")
                val height: String?,
                @Json(name = "width")
                val width: String?,
                @Json(name = "size")
                val size: String?,
                @Json(name = "url")
                val url: String?
            )

            @Keep
            @JsonClass(generateAdapter = true)
            data class FixedHeight(
                @Json(name = "height")
                val height: String?,
                @Json(name = "width")
                val width: String?,
                @Json(name = "size")
                val size: String?,
                @Json(name = "url")
                val url: String?,
                @Json(name = "mp4_size")
                val mp4Size: String?,
                @Json(name = "mp4")
                val mp4: String?,
                @Json(name = "webp_size")
                val webpSize: String?,
                @Json(name = "webp")
                val webp: String?
            )

            @Keep
            @JsonClass(generateAdapter = true)
            data class FixedHeightDownsampled(
                @Json(name = "height")
                val height: String?,
                @Json(name = "width")
                val width: String?,
                @Json(name = "size")
                val size: String?,
                @Json(name = "url")
                val url: String?,
                @Json(name = "webp_size")
                val webpSize: String?,
                @Json(name = "webp")
                val webp: String?
            )

            @Keep
            @JsonClass(generateAdapter = true)
            data class FixedHeightSmall(
                @Json(name = "height")
                val height: String?,
                @Json(name = "width")
                val width: String?,
                @Json(name = "size")
                val size: String?,
                @Json(name = "url")
                val url: String?,
                @Json(name = "mp4_size")
                val mp4Size: String?,
                @Json(name = "mp4")
                val mp4: String?,
                @Json(name = "webp_size")
                val webpSize: String?,
                @Json(name = "webp")
                val webp: String?
            )

            @Keep
            @JsonClass(generateAdapter = true)
            data class FixedHeightSmallStill(
                @Json(name = "height")
                val height: String?,
                @Json(name = "width")
                val width: String?,
                @Json(name = "size")
                val size: String?,
                @Json(name = "url")
                val url: String?
            )

            @Keep
            @JsonClass(generateAdapter = true)
            data class FixedHeightStill(
                @Json(name = "height")
                val height: String?,
                @Json(name = "width")
                val width: String?,
                @Json(name = "size")
                val size: String?,
                @Json(name = "url")
                val url: String?
            )

            @Keep
            @JsonClass(generateAdapter = true)
            data class FixedWidth(
                @Json(name = "height")
                val height: String?,
                @Json(name = "width")
                val width: String?,
                @Json(name = "size")
                val size: String?,
                @Json(name = "url")
                val url: String?,
                @Json(name = "mp4_size")
                val mp4Size: String?,
                @Json(name = "mp4")
                val mp4: String?,
                @Json(name = "webp_size")
                val webpSize: String?,
                @Json(name = "webp")
                val webp: String?
            )

            @Keep
            @JsonClass(generateAdapter = true)
            data class FixedWidthDownsampled(
                @Json(name = "height")
                val height: String?,
                @Json(name = "width")
                val width: String?,
                @Json(name = "size")
                val size: String?,
                @Json(name = "url")
                val url: String?,
                @Json(name = "webp_size")
                val webpSize: String?,
                @Json(name = "webp")
                val webp: String?
            )

            @Keep
            @JsonClass(generateAdapter = true)
            data class FixedWidthSmall(
                @Json(name = "height")
                val height: String?,
                @Json(name = "width")
                val width: String?,
                @Json(name = "size")
                val size: String?,
                @Json(name = "url")
                val url: String?,
                @Json(name = "mp4_size")
                val mp4Size: String?,
                @Json(name = "mp4")
                val mp4: String?,
                @Json(name = "webp_size")
                val webpSize: String?,
                @Json(name = "webp")
                val webp: String?
            )

            @Keep
            @JsonClass(generateAdapter = true)
            data class FixedWidthSmallStill(
                @Json(name = "height")
                val height: String?,
                @Json(name = "width")
                val width: String?,
                @Json(name = "size")
                val size: String?,
                @Json(name = "url")
                val url: String?
            )

            @Keep
            @JsonClass(generateAdapter = true)
            data class FixedWidthStill(
                @Json(name = "height")
                val height: String?,
                @Json(name = "width")
                val width: String?,
                @Json(name = "size")
                val size: String?,
                @Json(name = "url")
                val url: String?
            )

            @Keep
            @JsonClass(generateAdapter = true)
            data class Looping(
                @Json(name = "mp4_size")
                val mp4Size: String?,
                @Json(name = "mp4")
                val mp4: String?
            )

            @Keep
            @JsonClass(generateAdapter = true)
            data class OriginalStill(
                @Json(name = "height")
                val height: String?,
                @Json(name = "width")
                val width: String?,
                @Json(name = "size")
                val size: String?,
                @Json(name = "url")
                val url: String?
            )

            @Keep
            @JsonClass(generateAdapter = true)
            data class OriginalMp4(
                @Json(name = "height")
                val height: String?,
                @Json(name = "width")
                val width: String?,
                @Json(name = "mp4_size")
                val mp4Size: String?,
                @Json(name = "mp4")
                val mp4: String?
            )

            @Keep
            @JsonClass(generateAdapter = true)
            data class Preview(
                @Json(name = "height")
                val height: String?,
                @Json(name = "width")
                val width: String?,
                @Json(name = "mp4_size")
                val mp4Size: String?,
                @Json(name = "mp4")
                val mp4: String?
            )

            @Keep
            @JsonClass(generateAdapter = true)
            data class PreviewGif(
                @Json(name = "height")
                val height: String?,
                @Json(name = "width")
                val width: String?,
                @Json(name = "size")
                val size: String?,
                @Json(name = "url")
                val url: String?
            )

            @Keep
            @JsonClass(generateAdapter = true)
            data class PreviewWebp(
                @Json(name = "height")
                val height: String?,
                @Json(name = "width")
                val width: String?,
                @Json(name = "size")
                val size: String?,
                @Json(name = "url")
                val url: String?
            )

            @Keep
            @JsonClass(generateAdapter = true)
            data class Hd(
                @Json(name = "height")
                val height: String?,
                @Json(name = "width")
                val width: String?,
                @Json(name = "mp4_size")
                val mp4Size: String?,
                @Json(name = "mp4")
                val mp4: String?
            )

            @Keep
            @JsonClass(generateAdapter = true)
            data class WStill(
                @Json(name = "height")
                val height: String?,
                @Json(name = "width")
                val width: String?,
                @Json(name = "size")
                val size: String?,
                @Json(name = "url")
                val url: String?
            )
        }

        @Keep
        @JsonClass(generateAdapter = true)
        data class User(
            @Json(name = "avatar_url")
            val avatarUrl: String?,
            @Json(name = "banner_image")
            val bannerImage: String?,
            @Json(name = "banner_url")
            val bannerUrl: String?,
            @Json(name = "profile_url")
            val profileUrl: String?,
            @Json(name = "username")
            val username: String?,
            @Json(name = "display_name")
            val displayName: String?,
            @Json(name = "description")
            val description: String?,
            @Json(name = "instagram_url")
            val instagramUrl: String?,
            @Json(name = "website_url")
            val websiteUrl: String?,
            @Json(name = "is_verified")
            val isVerified: Boolean?
        )

        @Keep
        @JsonClass(generateAdapter = true)
        data class Analytics(
            @Json(name = "onload")
            val onload: Onload?,
            @Json(name = "onclick")
            val onclick: Onclick?,
            @Json(name = "onsent")
            val onsent: Onsent?
        ) {
            @Keep
            @JsonClass(generateAdapter = true)
            data class Onload(
                @Json(name = "url")
                val url: String?
            )

            @Keep
            @JsonClass(generateAdapter = true)
            data class Onclick(
                @Json(name = "url")
                val url: String?
            )

            @Keep
            @JsonClass(generateAdapter = true)
            data class Onsent(
                @Json(name = "url")
                val url: String?
            )
        }
    }

    @Keep
    @JsonClass(generateAdapter = true)
    data class Pagination(
        @Json(name = "total_count")
        val totalCount: Int?,
        @Json(name = "count")
        val count: Int?,
        @Json(name = "offset")
        val offset: Int?
    )

    @Keep
    @JsonClass(generateAdapter = true)
    data class Meta(
        @Json(name = "status")
        val status: Int?,
        @Json(name = "msg")
        val msg: String?,
        @Json(name = "response_id")
        val responseId: String?
    )
}
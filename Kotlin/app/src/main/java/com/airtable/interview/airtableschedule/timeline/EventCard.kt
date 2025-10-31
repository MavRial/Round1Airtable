package com.airtable.interview.airtableschedule.timeline

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airtable.interview.airtableschedule.models.Event

@Composable
fun EventCard(
    event: Event,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(6.dp))
            .background(Color(0xFF2196F3))
            .border(1.dp, Color(0xFF1976D2), RoundedCornerShape(6.dp))
            .padding(horizontal = 6.dp, vertical = 4.dp)
    ) {
        Text(
            text = event.name,
            color = Color.White,
            fontSize = 18.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}
package com.airtable.interview.airtableschedule.timeline

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airtable.interview.airtableschedule.models.Event
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun DaysHeader(lanes: List<List<Event>>, scrollState: ScrollState) {
    val dayWidth = 80.dp
    val minStartDate = lanes.flatten().minOfOrNull { it.startDate.time } ?: return
    val maxEndDate = lanes.flatten().maxOfOrNull { it.endDate.time } ?: return
    val totalDays = ((maxEndDate - minStartDate) / (1000 * 60 * 60 * 24)).toInt() + 1

    Row(modifier = Modifier.horizontalScroll(scrollState)) {
        repeat(totalDays) { day ->
            val date = Date(minStartDate + day * 24L * 60 * 60 * 1000)
            Box(
                modifier = Modifier
                    .width(dayWidth)
                    .height(32.dp)
                    .border(0.5.dp, Color.LightGray),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = SimpleDateFormat("MMM d", Locale.getDefault()).format(date),
                    fontSize = 14.sp
                )
            }
        }
    }
}



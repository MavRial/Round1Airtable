package com.airtable.interview.airtableschedule.timeline

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.airtable.interview.airtableschedule.models.Event


@Suppress("unused")
@Composable
fun TimelineContent(lanes: List<List<Event>>) {
    val dayWidth = 80.dp
    val eventHeight = 48.dp
    val minStartDate = lanes.flatten().minOfOrNull { it.startDate.time } ?: return
    val maxEndDate = lanes.flatten().maxOfOrNull { it.endDate.time } ?: return
    val totalDays = ((maxEndDate - minStartDate) / (1000 * 60 * 60 * 24)).toInt() + 1

    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        lanes.forEach { lane ->
            Box(
                modifier = Modifier
                    .height(eventHeight)
                    .fillMaxWidth()
            ) {
                repeat(totalDays) { day ->
                    Box(
                        modifier = Modifier
                            .offset(x = dayWidth * day)
                            .width(1.dp)
                            .fillMaxHeight()
                            .background(Color.LightGray.copy(alpha = 0.5f))
                    )
                }

                lane.forEach { event ->
                    val startOffsetDays =
                        ((event.startDate.time - minStartDate) / (1000 * 60 * 60 * 24)).toInt()
                    val durationDays =
                        ((event.endDate.time - event.startDate.time) / (1000 * 60 * 60 * 24)).toInt() + 1

                    EventCard(
                        event = event,
                        modifier = Modifier
                            .offset(x = dayWidth * startOffsetDays)
                            .width(dayWidth * durationDays)
                            .height(eventHeight)
                    )
                }
            }
        }
    }
}
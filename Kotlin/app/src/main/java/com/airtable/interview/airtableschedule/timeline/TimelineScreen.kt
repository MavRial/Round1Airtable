package com.airtable.interview.airtableschedule.timeline

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.airtable.interview.airtableschedule.models.Event

/**
 * A screen that displays a timeline of events.
 */
@Composable
fun TimelineScreen(
    viewModel: TimelineViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    TimelineView(uiState.lanes)
}

/**
 * A view that displays a list of events in swimlanes format.
 * TODO: Replace the exiting list with Swimlanes
 *
 * @param events The list of events to display.
 */
@Composable
private fun TimelineView(lanes: List<List<Event>>) {
    LazyColumn {
        items(lanes) { lane ->
            Row(modifier = Modifier.fillMaxWidth()) {
                lane.forEach { event ->
                    EventView(event)
                }
            }
        }
    }
}

/**
 * Single event view.
 * TODO: This needs to be updated as needed
 */
@Composable
private fun EventView(event: Event) {
    val durationDays = ((event.endDate.time - event.startDate.time) / (1000*60*60*24)).toInt() + 1

    Box(
        modifier = Modifier
            .width((durationDays * 20).dp)
            .height(40.dp)
            .padding(2.dp)
            .background(Color.Blue),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = event.name,
            color = Color.White,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            fontSize = 12.sp
        )
    }
}

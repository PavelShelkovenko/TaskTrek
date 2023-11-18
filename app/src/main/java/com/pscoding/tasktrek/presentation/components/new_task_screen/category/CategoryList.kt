package com.pscoding.tasktrek.presentation.components.new_task_screen.category

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.Placeable

@Composable
fun CategoryList(
    modifier: Modifier = Modifier,
    horizontalSpacing: Int = 0,
    verticalSpacing: Int = 0,
    content: @Composable () -> Unit
) {
    Layout(
        modifier = modifier,
        measurePolicy = { measurables, constraints ->
            val placeables = measurables.map {
                it.measure(constraints)
            }

            val groupedPlaceables = mutableListOf<List<Placeable>>()
            var currentGroup = mutableListOf<Placeable>()
            var currentGroupWidth = 0

            placeables.forEach { placeable ->
                if (currentGroupWidth + placeable.width <= constraints.maxWidth - horizontalSpacing - 10) {
                    currentGroup.add(placeable)
                    currentGroupWidth += placeable.width
                } else {
                    groupedPlaceables.add(currentGroup)
                    currentGroup = mutableListOf(placeable)
                    currentGroupWidth = placeable.width
                }
            }

            if (currentGroup.isNotEmpty()) {
                groupedPlaceables.add(currentGroup)
            }

            var layoutHeight = 0

            groupedPlaceables.forEach { row ->
                layoutHeight += row.maxOfOrNull { it.height + verticalSpacing } ?: 0
            }

            layout(
                width = constraints.maxWidth,
                height = layoutHeight - verticalSpacing
            ) {
                var yPosition = 0
                groupedPlaceables.forEach { row ->
                    var xPosition = 0
                    row.forEach { placeable ->
                        placeable.place(
                            x = xPosition,
                            y = yPosition
                        )
                        xPosition += placeable.width + horizontalSpacing
                    }
                    yPosition += row.maxOfOrNull { it.height + verticalSpacing } ?: 0
                }
            }
        },
        content = content
    )
}
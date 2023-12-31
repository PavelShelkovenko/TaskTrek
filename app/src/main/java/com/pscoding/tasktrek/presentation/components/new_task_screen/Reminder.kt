package com.pscoding.tasktrek.presentation.components.new_task_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pscoding.tasktrek.R
import com.pscoding.tasktrek.presentation.theme.TaskTrekTheme

@Composable
fun Reminder(
    remindStatus: Boolean,
    onRemindStatusChanged: (Boolean) -> Unit
) {

    val icon: (@Composable () -> Unit)? = if (remindStatus) {
        {
            Icon(
                imageVector = Icons.Filled.Check,
                contentDescription = null,
                modifier = Modifier.size(SwitchDefaults.IconSize),
            )
        }
    } else {
        null
    }

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .background(MaterialTheme.colorScheme.background)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_notification),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier
                    .padding(6.dp)
                    .size(28.dp)
            )
        }
        Text(
            text = stringResource(id = R.string.remind_me),
            style = MaterialTheme.typography.displayMedium,
            color = MaterialTheme.colorScheme.onSecondary,
            modifier = Modifier.padding(start = 12.dp)
        )
        Spacer(modifier = Modifier.weight(1f))
        Switch(
            checked = remindStatus,
            onCheckedChange = {
                onRemindStatusChanged(it)
            },
            thumbContent = icon,
            colors = SwitchDefaults.colors(
                checkedIconColor = MaterialTheme.colorScheme.onSecondary,
                checkedBorderColor = MaterialTheme.colorScheme.onSecondary,
                checkedTrackColor = MaterialTheme.colorScheme.onSecondary,
                uncheckedThumbColor = MaterialTheme.colorScheme.onPrimary,
                uncheckedTrackColor = MaterialTheme.colorScheme.background
            )
        )
    }
}

@Preview
@Composable
fun PreviewReminder() {
    TaskTrekTheme {
        Reminder(
            remindStatus = false,
            onRemindStatusChanged = {}
        )
    }
}
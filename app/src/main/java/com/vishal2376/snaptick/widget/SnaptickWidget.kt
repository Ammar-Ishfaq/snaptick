package com.vishal2376.snaptick.widget

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.GlanceTheme
import androidx.glance.ImageProvider
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.lazy.LazyColumn
import androidx.glance.appwidget.lazy.items
import androidx.glance.appwidget.provideContent
import androidx.glance.background
import androidx.glance.layout.Box
import androidx.glance.layout.Column
import androidx.glance.layout.fillMaxWidth
import androidx.glance.layout.padding
import androidx.glance.material3.ColorProviders
import androidx.glance.text.Text
import com.vishal2376.snaptick.R
import com.vishal2376.snaptick.domain.model.Task
import com.vishal2376.snaptick.ui.theme.DarkColorScheme
import com.vishal2376.snaptick.util.DummyTasks

class SnaptickWidget : GlanceAppWidget() {

	override suspend fun provideGlance(context: Context, id: GlanceId) {
		provideContent {
			GlanceTheme(ColorProviders(DarkColorScheme)) {
				WidgetContent()
			}
		}
	}

	@Composable
	private fun WidgetContent() {
		Column(
			modifier = GlanceModifier.fillMaxWidth()
				.background(GlanceTheme.colors.primary)
				.padding(16.dp)
		) {
			LazyColumn {
				items(DummyTasks.tasks) { task ->
					TaskWidget(task)
				}
			}
		}
	}

	@Composable
	fun TaskWidget(task: Task) {
		Box(
			modifier = GlanceModifier
				.fillMaxWidth()
				.background(ImageProvider(R.drawable.task_bg_shape))
				.padding(16.dp),
		) {
			Text(text = task.title)
		}
	}
}
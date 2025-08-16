@file:OptIn(ExperimentalMaterial3Api::class)
package com.example.myapplication


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.myapplication.model.Tutor

@Composable
fun TutorProfileScreen(tutor: Tutor, onBack: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(tutor.name) },
                navigationIcon = {
                    IconButton(onClick = { onBack() }) {
                        Icon(Icons.Default.CheckCircle, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = tutor.imageResId),
                contentDescription = "Tutor Image",
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
                    .align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text("Subject: ${tutor.subject}", style = MaterialTheme.typography.bodyLarge)
            Text("Rating: ${tutor.rating}", style = MaterialTheme.typography.bodyLarge)
            Text("Verified: ${if (tutor.verified) "Yes" else "No"}", style = MaterialTheme.typography.bodyLarge)

            Spacer(modifier = Modifier.height(16.dp))
            Text("Bio: Problem solver!", style = MaterialTheme.typography.bodyMedium)
        }
    }
}

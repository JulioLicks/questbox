sed -i 's/import androidx.compose.material.icons.filled.Visibility/import androidx.compose.material.icons.filled.Visibility\nimport androidx.compose.material.icons.filled.ChevronRight/' /app/applet/app/src/main/java/com/example/ui/components/CompassWheel.kt
cat << 'INNER_EOF' > chevron.txt
                        }
                    }
                    Icon(
                        imageVector = Icons.Default.ChevronRight,
                        contentDescription = "Abrir",
                        tint = cardColor
                    )
                }
            }
INNER_EOF
sed -i -e '/                            } \/\/ End AttributeItem/,$ d' /app/applet/app/src/main/java/com/example/ui/components/CompassWheel.kt
cat << 'INNER_EOF2' >> /app/applet/app/src/main/java/com/example/ui/components/CompassWheel.kt
                            } // End AttributeItem
                        }
                    }
                    Icon(
                        imageVector = Icons.Default.ChevronRight,
                        contentDescription = "Abrir",
                        tint = cardColor
                    )
                }
            }
        }
    }
}
INNER_EOF2

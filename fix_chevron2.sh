cat << 'INNER_EOF' > chevron2.txt
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
INNER_EOF
sed -i -e '364,369c\
                        }\
                    }\
                    Icon(\
                        imageVector = Icons.Default.ChevronRight,\
                        contentDescription = "Abrir",\
                        tint = cardColor\
                    )\
                }\
            }\
        }\
    }\
}' /app/applet/app/src/main/java/com/example/ui/components/CompassWheel.kt

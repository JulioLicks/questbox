import re

with open("/app/applet/app/src/main/java/com/example/ui/components/CardFormDialog.kt", "r") as f:
    content = f.read()

# Remove the AI Suggestion Banner
ai_banner_pattern = r'// AI Suggestion Banner.*?// Show AI Last Response if available.*?}\n'
content = re.sub(ai_banner_pattern, '', content, flags=re.DOTALL)

with open("/app/applet/app/src/main/java/com/example/ui/components/CardFormDialog.kt", "w") as f:
    f.write(content)

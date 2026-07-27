# Security Policy

## Reporting a Vulnerability

If you discover a security vulnerability in Questbox, please **DO NOT** open a public issue. Instead, please send an email to:

**security@questbox.com**

Include:
- Description of vulnerability
- Steps to reproduce (if possible)
- Potential impact
- Your suggested fix (if any)

We will investigate all reported vulnerabilities and will do our best to fix them promptly.

## Security Best Practices

### For Users

1. **Keep Flutter Updated**
   - Regularly update Flutter SDK
   - Run: `flutter upgrade`

2. **Environment Variables**
   - Never commit `.env` file to version control
   - Keep API keys confidential
   - Use different keys for different environments

3. **Firebase Security**
   - Enable two-factor authentication
   - Use strong passwords
   - Review Firebase security rules regularly

4. **Device Security**
   - Keep your device OS updated
   - Use device passcode/biometric
   - Don't install apps from untrusted sources

### For Developers

1. **Code Security**
   - Validate all user inputs
   - Use parameterized queries
   - Avoid hardcoding secrets
   - Use HTTPS for all API calls

2. **Dependencies**
   - Keep dependencies updated
   - Review dependency security advisories
   - Use `flutter pub outdated` regularly

3. **Authentication**
   - Use secure authentication methods
   - Store tokens securely
   - Implement token expiration
   - Use Firebase security rules

4. **Data Storage**
   - Encrypt sensitive data
   - Use secure storage solutions
   - Minimize data collection
   - Implement data expiration

## Firebase Security Rules

Example secure rules:

```javascript
rules_version = '2';
service cloud.firestore {
  match /databases/{database}/documents {
    // Allow users to read/write their own data
    match /users/{userId} {
      allow read, write: if request.auth.uid == userId;
    }
    
    // Allow users to read/write their own quests
    match /quests/{questId} {
      allow read, write: if request.auth.uid == resource.data.userId;
    }
  }
}
```

## API Security

1. **Rate Limiting**
   - Implement rate limiting on backend
   - Use 429 Too Many Requests response

2. **Authentication**
   - Use JWT tokens
   - Implement token refresh
   - Validate tokens on backend

3. **HTTPS**
   - Always use HTTPS
   - Validate SSL certificates
   - Use certificate pinning for sensitive apps

4. **Input Validation**
   - Validate all inputs on backend
   - Use whitelist validation
   - Sanitize outputs

## Dependency Security

Monitor security advisories:
```bash
# Check for vulnerabilities
flutter pub outdated
flutter pub upgrade --major-versions
dart pub audit
```

## Incident Response

If a security vulnerability is discovered:

1. **Acknowledge receipt** within 48 hours
2. **Investigate** the vulnerability
3. **Develop fix** with priority
4. **Test thoroughly** before release
5. **Release patch** version
6. **Publish advisory** with credit to reporter

## Compliance

- GDPR compliant data handling
- No unnecessary data collection
- Users can request data deletion
- Transparent privacy policy

## Updates and Patches

Security patches will be released as soon as possible. Subscribe to releases:

1. Watch repository on GitHub
2. Enable notifications for releases
3. Follow @questbox on social media

## Contact

- Security issues: security@questbox.com
- General support: support@questbox.com
- Questions: hello@questbox.com

---

Thank you for helping keep Questbox secure! 🛡️

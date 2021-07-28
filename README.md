# CustomVideoView

Android VideoView cannot play https network video problem

To fix this problem, you need to create CustomVideoView. And override its method

```javascript
@Override
    public void setVideoURI(Uri uri) {
        super.setVideoURI(uri);
        try {
            HttpsURLConnection.setDefaultSSLSocketFactory(SSlUtiles.createSSLSocketFactory());
            HttpsURLConnection.setDefaultHostnameVerifier(new SSlUtiles.TrustAllHostnameVerifier());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
```

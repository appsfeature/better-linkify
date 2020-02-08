# YTPlayer 

The Android YTPlayer library is a stable and customizable open source YouTube player for Android. 


<p align="left">
  <img src="https://raw.githubusercontent.com/appsfeature/yt-player/master/screenshots/sample1.png" alt="Preview 1" width="200" /> 
</p>
  
## Setup Project

Add this to your project build.gradle

Project-level build.gradle (<project>/build.gradle):

``` gradle 
allprojects {
    repositories {
        google()
        jcenter() 
        maven { url 'https://jitpack.io' } 
    }

    ext {
        appcompat = '1.1.0-alpha01'
    }
}
```

Add this to your project build.gradle

Module-level build.gradle (<module>/build.gradle): 

#### [![](https://jitpack.io/v/appsfeature/yt-player.svg)](https://jitpack.io/#appsfeature/yt-player)
```gradle  

dependencies {
    implementation 'com.github.appsfeature:yt-player:x.y'
} 
```

## Setup Google Developers Console
```
  To get started, you need a googleApiKey with YouTube Data API v3 enabled:
  Enable YouTube Data API v3 service. Go to mentioned url below for register a new developer key.  
  URl : https://console.developers.google.com 
``` 

In your activity class:
#### In App method
```java 
      YTPlayer ytPlayer = YTPlayer.getInstance(this, DeveloperKey.DEVELOPER_KEY)
                .setPlayerType(YTPlayer.VideoType.OPEN_INTERNAL_PLAYER)
                .maxListItemsCount(Constants.MAX_RESULTS_COUNT)
                .setTypeface(null);

       // For open single playlist 
       ytPlayer.openPlaylist("Playlist", YOUTUBE_GOOGLE_PLAY_PLAYLIST_ID); 

       // For open multiple playlist (YOUTUBE_MULTIPLE_PLAYLIST_IDS = Comma saperated playlist Ids)
       ytPlayer.openPlaylistMultipleIds("Multiple Playlist", YOUTUBE_MULTIPLE_PLAYLIST_IDS);
                
        // For open channel
       ytPlayer.openChannel("Channel", YOUTUBE_CHANNEL_ID);
                         
       // For open single video
       ytPlayer.setPlayerType(YTPlayer.VideoType.OPEN_INTERNAL_PLAYER);
       ytPlayer.openVideo(YOUTUBE_VIDEO_ID);

       // For open video playlist
       ArrayList<YTVideoModel> videosList = new ArrayList<>();
       YTVideoModel videoDetail = YTVideoModel.Builder()
                   .setVideoId("3gQym6mF2Jw")
                   .setTitle("How to Create a VR App for Android in 7 Minutes")
                   .setDuration("9.5");
       videosList.add(videoDetail);
       ytPlayer.openViewPlaylist("Youtube", videosList);  
       
       // For open search video option
       ytPlayer.setPlayerType(YTPlayer.VideoType.OPEN_INTERNAL_SLIDING_PLAYER);
       ytPlayer.openSearch(YOUTUBE_CHANNEL_ID); 

                                
```

#### External App method
```java 
      YTPlayer ytPlayer = YTPlayer.getInstance(this, DeveloperKey.DEVELOPER_KEY)
                .setPlayerType(YTPlayer.VideoType.OPEN_EXTERNAL)
                .maxListItemsCount(Constants.MAX_RESULTS_COUNT)
                .setTypeface(null); 
            
       // For open video playlist in external youtube player
       ytPlayer.openPlaylistExternal(YOUTUBE_PLAYLIST); 
       
       // For open single video in external youtube player
       ytPlayer.setPlayerType(YTPlayer.VideoType.OPEN_EXTERNAL);
       ytPlayer.openVideo(YOUTUBE_VIDEO_ID);

                                
```

#### Useful Links:
1. https://console.developers.google.com 

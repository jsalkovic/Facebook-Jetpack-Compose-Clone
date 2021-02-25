# Facebook Jetpack Compose Clone
Jetpack Compose clone of Facebook UI.

![Facebook Compose](https://josipsalkovic.com/facebook_compose.png)

## About
Facebook Jetpack Compose Clone is an Facebook clone app built entirely with [Jetpack Compose](https://developer.android.com/jetpack/compose). Version of Jetpack Compose that was used in this project is `1.0.0-alpha12`.

This sample showcases:
* Splash and Home screen
* Status update
* Show stories and their animations when loading
* Show posts with images
* Like posts
* Comment posts

Tools that are used in this project are as follows:
* [`Jetpack Navigation Compose`](https://developer.android.com/jetpack/compose/navigation) for navigation between composables.
* [`Coroutines`](https://developer.android.com/kotlin/coroutines) for async programming.
* [`Hilt`](https://developer.android.com/training/dependency-injection/hilt-android) for Depenency Injection.
* [`Retrofit`](https://square.github.io/retrofit/) for network requests.
* [`Glide`](https://bumptech.github.io/glide/) for image loading and cacheing.

## Setup 
* Download the latest canary version of [Android Studio Preview](https://developer.android.com/studio/preview).
* Clone repo and run app.

## Architecture
In this project, custom MVVM architecture based on ViewStates was used: [link](https://infinum.com/the-capsized-eight/MVVM-architecture).

## Design
Design that was used in this project: [link](https://www.behance.net/gallery/103521467/Facebook-2020-Redesign-mobile-app)

## Customization
* All data was mocked and it's located [here](https://github.com/jsalkovic/Facebook-Compose-App/blob/master/app/src/main/java/hr/josip/facebook/data/common/Mock.kt).
* To customize stories, just modify [`getStories()`](https://github.com/jsalkovic/Facebook-Compose-App/blob/master/app/src/main/java/hr/josip/facebook/data/common/Mock.kt) method.
* To customize posts, just modify [`getPosts()`](https://github.com/jsalkovic/Facebook-Compose-App/blob/master/app/src/main/java/hr/josip/facebook/data/common/Mock.kt) method.
* To change current active user, which is needed for status update and comments, go inside [`UserManager`](https://github.com/jsalkovic/Facebook-Compose-App/blob/master/app/src/main/java/hr/josip/facebook/shared/manager/user/UserManagerImpl.kt) and provide your own data.

## Status: 🚧 In progress 🚧

Facebook Jetpack Compose Clone is still under development and some screens are not implemented yet.

## License

```
Copyright 2020 Josip Šalković

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    https://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```


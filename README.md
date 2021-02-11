# AndroidTodoList
Simple TodoList app written in Kotlin using Android Studio

* Project made from Empty Activity project template

* Gradle is updated to support View Binding
```
buildFeatures {         // added for proper viewBinding
    viewBinding true    //
}                       //
```

* View Binding used instead of findViewById() and kotlin-android-extensions gradle plugin (In 1.4.20 the Kotlin Android Extensions plugin becomes deprecated)

  * View Binding examples for RecycleView.Adapter and Activity

* App does not have database features(might add in future)

## Useful links:
* https://youtu.be/BBWyXo-3JGQ - building Android app tutorial(slightly outdated - look in comment section for details)

* https://medium.com/swlh/how-to-use-view-binding-in-recyclerview-adapter-f818b96c678a - RecycleView.Adapter View Binding example

* https://developer.android.com/topic/libraries/view-binding - documentation on View Binding

* https://kotlinlang.org/docs/whatsnew1420.html#kotlin-android-extensions - about Kotlin Android Extensions deprecation

* https://kotlinlang.org/docs/scope-functions.html - documentation on Scope functions

* https://blog.mindorks.com/learn-kotlin-apply-vs-with - difference between with and apply
```
"Usually, you use apply when you need to do something with an object and return it. 
And when you need to perform some operations on an object and return some other object you can use with."
```

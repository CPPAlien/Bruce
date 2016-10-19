[![](https://jitpack.io/v/CPPAlien/Bruce.svg)](https://jitpack.io/#CPPAlien/Bruce)

# Bruce
Android应用主题库

###导入方法
```
allprojects {
	repositories {
		...
		maven { url "https://jitpack.io" }
	}
}

dependencies {
        compile 'com.github.CPPAlien:Bruce:0.0.8'
}
```

###用法注意
你需要设置在AndroidManifest.xml中设置application的主题为如下，颜色自定义
```
<style name="AppTheme" parent="BruceTheme">
    <item name="bruceTitleColor">#FF0000</item>
    <item name="bruceAccentColor">#00FF00</item>
</style>
```
bruceTitleColor：顶部标题栏位颜色，并且如果是5.0及以上手机，则状态栏也会变成该颜色。

bruceAccentColor：强调色，如EditText中的光标，Progressbar的颜色。
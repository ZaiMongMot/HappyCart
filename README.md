# Happykart - Sample E-Commerce App implementing maintainable and testable MVVM architecture using Data Binding, Dagger 2, RxJava 2, Retrofit, Realm.

<a href="https://github.com/ashutosh-verma/Happykart-mvvm-rxjava-dagger/blob/master/app-debug.apk">Download APK</a>

<b>Screen Shots</b>

<table>
<tr>
<td>
<img src="https://github.com/ashutosh-verma/Happykart-mvvm-rxjava-dagger/blob/master/screen-shots/categories.png"/>
</td>
<td>
<img src="https://github.com/ashutosh-verma/Happykart-mvvm-rxjava-dagger/blob/master/screen-shots/product_list.png"/>
</td>
<td>
<img src="https://github.com/ashutosh-verma/Happykart-mvvm-rxjava-dagger/blob/master/screen-shots/product_detail.png"/>
</td>
<td>
<img src="https://github.com/ashutosh-verma/Happykart-mvvm-rxjava-dagger/blob/master/screen-shots/product_detail_added_to_cart.png"
</td>
</tr>
</table>

#### The app has following packages:
1. **data**: It contains all the data accessing and manipulating components.
2. **di**: Dependency providing classes using Dagger2.
3. **ui**: View classes along with their corresponding ViewModel.
4. **utils**: Utility classes.

Classes have been designed in such a way that it could be inherited and maximize the code reuse.

Technical approach

- MVVM for clean code
- Repository pattern
- Dependency Inject
- Single source of truth pricple - for offline experince
- Material design

Additional to Requirement 
- Works in both orientation 
- All categories funtional
- Material design
- Graceful error handling

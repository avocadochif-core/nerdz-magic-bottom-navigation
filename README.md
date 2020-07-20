# nerdz-magic-bottom-navigation
Android library for BottomNavigationView.

## Installation

In project-level Gradle

```bash
maven { url 'https://jitpack.io' }
```

In app-level Gradle

```bash
implementation 'com.github.avocadochif-core:nerdz-magic-bottom-navigation:1.0.0'
```

## Usage(in MVVM)

```python
 bottomNavigation.onItemSelected { viewModel.onBottomItemChanged(it) }
 bottomNavigation.onItemReselected { viewModel.onBottomItemReselected(it) }
```

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.


## License
[MIT](https://choosealicense.com/licenses/mit/)

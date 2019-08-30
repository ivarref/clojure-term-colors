# clojure-term-colors

A Clojure library for ASCII terminal color output, based on python
termcolor package. GraalVM friendly.

![Screenshot](doc/info.png)

## Tools.deps

```
clojure-term-colors {:git/url "https://github.com/ivarref/clojure-term-colors.git"
                     :sha "e161e677f1ff31a61a64fa0d3c388bdb4470a8a2"}
```

## Usage

![Example](doc/example.png)

_You can also set the `*disable-colors*` flag variable (using binding) if you want
to disable colors temporarily._

## Available Functions

```
white, cyan, magenta, blue, yellow, green, red, grey, on-white,
on-cyan, on-magenta, on-blue, on-yellow, on-green, on-red, on-grey,
concealed, reverse-color, blink, underline, dark, bold
```

## License

Copyright © 2014 Thura Hlaing

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.

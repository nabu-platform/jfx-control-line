# Description

The jfx line component has one problem: hit surface.

I needed lines that were clickable by the user but a 1 pixel target is too small to hit and a larger line is both ugly and unwieldy if you need a lot of lines.
In the beginning I use a 1 pixel line and css to make it bigger on hover (e.g. 5px) but it is far from ideal.

This very lightweight component extends the default Line component and adds an invisible line with a larger surface that redirects its events to this line.

```java
Line line = new Line();
// this will update the stroke width of the hidden line hence enlarging the hittable surface
line.eventSizeProperty().set(5);
```
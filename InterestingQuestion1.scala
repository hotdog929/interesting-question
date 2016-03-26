#!/usr/bin/env scalas

/***
  scalaVersion := "2.11.6"
*/

/*
題目：
下面算式中，不同字母代表不同的數字，
相同的字母表示相同的數字，
範圍是 1 到 9 不含 0，
請問可能的解有幾種?

   A B
-  C D
-------
   E F
+  G H
-------
 P P P
 */

/*
解法概要：
因為任意二位數的正數相加一定不可能超過200，所以推得 P = 1，然後把二位數字合併成一個數字

   W
-  X
-----
   Y
+  Z
-----
 111

因為 0 和 1 已經不能用了，所以 W,X,Y,Z 必定是大於 20 的數字
因為 W - X 必需為正數，所以 W > X
上述的條件可以推得
for(
  w <- (21..98),
  x <- (21..98),
  z <- (21..98)
)when(
  w > x,
  y = w - x,
  y > 20,
  y + z == 111,
  r = (w.toString + x.toString + y.toString + z.toString),
  r.toSet.length == 8,
  !r.contains('0')
).length
 */

val answers = for {
  w <- (21 to 98)
  x <- (21 to 98)
  z <- (21 to 98)
  if w > x
  y = w - x
  if y > 20
  if y + z == 111
  r = w.toString + x.toString + y.toString + z.toString
  if r.toSet.size == 8
  if !r.contains("0")
} yield (w, x, y, z)
println(s"total answers is ${answers.size},\ndetails :\n${answers}")

/*
total answers is 3,
details :
Vector((85,46,39,72), (86,54,32,79), (95,27,68,43))
*/

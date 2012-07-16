

var n_1 = 1;
var n_2 = 0;
var n = 1;
var sum = 0;

while(n < 4000000) {
  n_2 = n_1;
  n_1 = n;
  n = n_2 + n_1;
  if (n % 2 == 0) {
    sum += n
  }

}

println(sum);

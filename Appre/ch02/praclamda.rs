#![allow(dead_code, unused)]

#[macro_use]
macro_rules! pp {
    ($($x:expr),+) => {{
        $(
        println!("{:?}", $x);
        )+
    }};
}

fn main() {
    //println!("{}", math_sum(10, |a| { a * a }));
    pp!(math_sum(10, |a| { a * a }));
    pp!(math_sum(10, fibo));
}

fn math_sum(length: u32, series: fn(u32) -> u32) -> u32 {
    let mut sum = 0;
    for item in 0..=length {
        sum += series(item);
    }
    sum
}

fn fibo(num: u32) -> u32 {
    match (num) {
        0 => 0,
        1 | 2 => 1,
        _ => fibo(num - 2) + fibo(num - 1),
    }
}

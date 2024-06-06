#!/bin/bash
rm -rf out
mkdir out out/build
cd out/build
cmake ../../
make
make install
#!/bin/bash

echo "Starting submission for part 10 exercises..."
for d in part10*; do
  if [ -d "$d" ]; then
    echo "Submitting $d..."
    (cd "$d" && yes n | tmc submit)
  fi
done
echo "Finished submitting part 10!"

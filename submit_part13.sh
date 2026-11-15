#!/bin/bash

echo "Starting submission for part 13 exercises..."
for d in part13*; do
  if [ -d "$d" ]; then
    echo "Submitting $d..."
    (cd "$d" && yes n | tmc submit)
  fi
done
echo "Finished submitting part 13!"

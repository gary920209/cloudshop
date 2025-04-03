#!/bin/bash

CLI_CMD="java -cp target/classes com.example.App"

# Test 1: Register user
OUTPUT=$($CLI_CMD REGISTER user1)
EXPECTED="Success"
if [ "$OUTPUT" == "$EXPECTED" ]; then
    echo "✅ REGISTER test passed"
else
    echo "❌ REGISTER test failed: Expected '$EXPECTED', but got '$OUTPUT'"
    exit 1
fi

# Test 2: Create listing
OUTPUT=$($CLI_CMD CREATE_LISTING user1 'Phone model 8' 'Black color, brand new' 1000 'Electronics')
EXPECTED="100001"
if [ "$OUTPUT" == "$EXPECTED" ]; then
    echo "✅ CREATE_LISTING test passed"
else
    echo "❌ CREATE_LISTING test failed: Expected '$EXPECTED', but got '$OUTPUT'"
    exit 1
fi

# Test 3: Get listing details
OUTPUT=$($CLI_CMD GET_LISTING user1 100001)
EXPECTED="Phone model 8|Black color, brand new|1000|2019-02-22 12:34:56|Electronics|user1"
if [ "$OUTPUT" == "$EXPECTED" ]; then
    echo "✅ GET_LISTING test passed"
else
    echo "❌ GET_LISTING test failed: Expected '$EXPECTED', but got '$OUTPUT'"
    exit 1
fi

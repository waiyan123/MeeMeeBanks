# First question (Floor partitions)
# Language - Kotlin

var floor = arrayOf(
            arrayOf(0, 0, 0, 0),
            arrayOf(0, 0, 0, 0),
            arrayOf(0, 0, 0, 0),
            arrayOf(0, 0, 0, 0)
        )

        var partitions = 0

        for (i in 0..3) {
            for (j in 0..3) {

                partitions++
                floor[i][j] = 1

                if (j > 0) {
                    if (j > 0 && floor[i][j - 1] == 1) {
                        floor[i][j] = 0
                        partitions--
                    }
                }
                else if (i > 0) {
                    if (i > 0 && floor[i - 1][j] == 1) {
                        floor[i][j] = 0
                        partitions--
                    }
                }

            }
        }
        System.out.print("Partitions ",partitions)

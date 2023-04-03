import java.io.File
import org.jetbrains.letsPlot.export.ggsave
import org.jetbrains.letsPlot.geom.geomHistogram
import org.jetbrains.letsPlot.ggsize
import org.jetbrains.letsPlot.letsPlot

fun main(args: Array<String>) {
    println("Start text analysis")
    // the max size for readText() is 2 GB
    // this reads file in a string
    val inputString: String = File("Tolstoy.txt").reader().use {it.readText()}
    // split the sentences
    val stringArr: List<String> = inputString.split(".", "?", "!")
    // init array of number of words in each sentence
    val stringAnalytics: MutableList<Int> = mutableListOf()
    // check for exceptions and fill the array
    for(i in 0 until stringArr.size - 1) {
        val size: Int = stringArr[i].split(" ").size
        val firstWordLength = stringArr[i].split(" ")[0].length
        if (size > 0 && firstWordLength > 1) stringAnalytics.add(size)
    }
    // using lets-plot API to build a histogram
    val data = mapOf("words in sentence" to stringAnalytics)
    val p = letsPlot(data) {x = "words in sentence"} +
            geomHistogram(binWidth = 1) + ggsize(1000, 500)
    // save it
    ggsave(p, "histogram.png")
    //File("outputFile.txt").writer().use {it.write(inputString)}
    println("End text analysis")
}
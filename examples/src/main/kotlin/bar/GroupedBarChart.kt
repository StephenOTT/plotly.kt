package bar

import hep.dataforge.meta.invoke
import kscience.plotly.Plotly
import kscience.plotly.makeFile
import kscience.plotly.models.Bar
import kscience.plotly.models.BarMode
import kscience.plotly.palettes.Xkcd


/**
 * - Grouped bar chart
 * - Use XKCD color palette
 */
fun main() {
    val trace1 = Bar {
        x("giraffes", "orangutans", "monkeys")
        y(20, 14, 23)
        name = "SF Zoo"
        marker {
            color(Xkcd.GREEN)
        }
    }

    val trace2 = Bar {
        x("giraffes", "orangutans", "monkeys")
        y(12, 18, 29)
        name = "LA Zoo"
        marker {
            color(Xkcd.BLUE)
        }
    }

    val plot = Plotly.plot {
        traces(trace1, trace2)

        layout {
            title = "Grouped Bar Chart"
            barmode = BarMode.group
        }
    }
    plot.makeFile()
}
class Solution {
        fun solution(players: Array<String>, callings: Array<String>): Array<String> {
        var answer: Array<String> = arrayOf<String>()
        val playerHashMap: HashMap<String, Int> = HashMap()
        var i = 0

        players.forEach {
            playerHashMap.put(it, i)
            i++
        }

        callings.forEach {
            val temp: String
            val rank = playerHashMap[it]!!

            temp = players[rank]
            players[rank] = players[rank - 1]
            players[rank - 1] = temp

            playerHashMap[it] = rank - 1
            playerHashMap[players[rank]] = rank
        }

        answer = players
        return answer
    }
}
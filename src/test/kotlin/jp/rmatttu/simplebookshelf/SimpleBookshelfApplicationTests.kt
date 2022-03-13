package jp.rmatttu.simplebookshelf

import jp.rmatttu.simplebookshelf.view.Pager
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class SimpleBookshelfApplicationTests {

    @Test
    fun contextLoads() {
        // TODO: 考慮する
        // * null
        // * 空（""）
        // * max値
        // * 制御文字
    }

    @Test
    fun checkPagingInfo() {
        val pagerRecordEmpty = Pager(5, 0)
        var info = pagerRecordEmpty.generatePagingInfo(0)
        assert(info.hasNextPage.not())
        assert(info.hasPrevPage.not())

        val pagerRecordOne = Pager(5, 1)
        info = pagerRecordOne.generatePagingInfo(0)
        assert(info.hasNextPage.not())
        assert(info.hasPrevPage.not())

        val pager1 = Pager(3, 10)
        // ページは0, 1, 2, 3 の計4ページ
        info = pager1.generatePagingInfo(0)
        assert(info.hasPrevPage.not())
        assert(info.hasNextPage)
        info = pager1.generatePagingInfo(1)
        assert(info.hasPrevPage)
        assert(info.hasNextPage)
        info = pager1.generatePagingInfo(3)
        assert(info.hasPrevPage)
        assert(info.hasNextPage.not())

        // 異常値
        info = pager1.generatePagingInfo(4)
        assert(info.hasPrevPage)
        assert(info.hasNextPage.not())
    }

}

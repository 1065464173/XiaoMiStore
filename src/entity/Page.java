package entity;

public class Page {

        // 开始端点
        private int startData=1;

        //当前页数
        private int currentPage;

        //单页数据量
        private int singlePageData=5;

        //总数据量
        private int totalData;

        //总页数=总数据量%单页数据量==0？总数据量/单页数据量：（总数据量/单页数据量）+1

        private int totalPage;

        public int getTotalPage() {
            return totalPage=totalData%singlePageData==0?totalData/singlePageData:(totalData/singlePageData)+1;
        }

        public void setTotalPage(int totalpage) {

            this.totalPage = totalpage;
        }

        public int getStartData() {
            return (currentPage-startData)*singlePageData;
        }

        public void setStartData(int startData) {
            this.startData = startData;
        }

        public int getCurrentPage() {
            return currentPage;  //(currentPage-startData)*singlePageData;
        }

        public void setCurrentPage(int currentPage) {
            this.currentPage = currentPage;
        }

        public int getSinglePageData() {
            return singlePageData;
        }

        public void setSinglePageData(int singlePageData) {
            this.singlePageData = singlePageData;
        }

        public int getTotalData() {
            return totalData;
        }

        public void setTotalData(int totalData) {
            this.totalData = totalData;
        }

}

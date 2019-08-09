package ml.docilealligator.infinityforreddit;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;

import java.util.Locale;

import retrofit2.Retrofit;

class PostDataSourceFactory extends DataSource.Factory {
    private Retrofit retrofit;
    private String accessToken;
    private Locale locale;
    private String subredditName;
    private String query;
    private int postType;
    private String sortType;
    private int filter;

    private PostDataSource postDataSource;
    private MutableLiveData<PostDataSource> postDataSourceLiveData;

    PostDataSourceFactory(Retrofit retrofit, String accessToken, Locale locale, int postType, String sortType,
                          int filter) {
        this.retrofit = retrofit;
        this.accessToken = accessToken;
        this.locale = locale;
        postDataSourceLiveData = new MutableLiveData<>();
        this.postType = postType;
        this.sortType = sortType;
        this.filter = filter;
    }

    PostDataSourceFactory(Retrofit retrofit, String accessToken, Locale locale, String subredditName,
                          int postType, String sortType, int filter) {
        this.retrofit = retrofit;
        this.accessToken = accessToken;
        this.locale = locale;
        this.subredditName = subredditName;
        postDataSourceLiveData = new MutableLiveData<>();
        this.postType = postType;
        this.sortType = sortType;
        this.filter = filter;
    }

    PostDataSourceFactory(Retrofit retrofit, String accessToken, Locale locale, String subredditName,
                          int postType, int filter) {
        this.retrofit = retrofit;
        this.accessToken = accessToken;
        this.locale = locale;
        this.subredditName = subredditName;
        postDataSourceLiveData = new MutableLiveData<>();
        this.postType = postType;
        this.filter = filter;
    }

    PostDataSourceFactory(Retrofit retrofit, String accessToken, Locale locale, String subredditName,
                          String query, int postType, String sortType, int filter) {
        this.retrofit = retrofit;
        this.accessToken = accessToken;
        this.locale = locale;
        this.subredditName = subredditName;
        this.query = query;
        postDataSourceLiveData = new MutableLiveData<>();
        this.postType = postType;
        this.sortType = sortType;
        this.filter = filter;
    }

    @Override
    public DataSource create() {
        if(postType == PostDataSource.TYPE_FRONT_PAGE) {
            postDataSource = new PostDataSource(retrofit, accessToken, locale, postType, sortType,
                    filter);
        } else if(postType == PostDataSource.TYPE_SEARCH) {
            postDataSource = new PostDataSource(retrofit, accessToken, locale, subredditName, query,
                    postType, sortType, filter);
        } else if(postType == PostDataSource.TYPE_SUBREDDIT) {
            postDataSource = new PostDataSource(retrofit, accessToken, locale, subredditName, postType,
                    sortType, filter);
        } else {
            postDataSource = new PostDataSource(retrofit, accessToken, locale, subredditName, postType,
                    filter);
        }

        postDataSourceLiveData.postValue(postDataSource);
        return postDataSource;
    }

    public MutableLiveData<PostDataSource> getPostDataSourceLiveData() {
        return postDataSourceLiveData;
    }

    PostDataSource getPostDataSource() {
        return postDataSource;
    }

    void changeSortType(String sortType) {
        this.sortType = sortType;
    }
}
